// 读取本地excel文件
function readWorkbookFromLocalFile(file, callback) {
    let reader = new FileReader();
    reader.onload = function(e) {
        let data = e.target.result;
        let workbook = XLSX.read(data, {type: 'binary'});
        if(callback) callback(workbook);
    };
    reader.readAsBinaryString(file);
}
function readWorkbook(workbook) {
    let sheetNames = workbook.SheetNames; // 工作表名称集合
    let worksheet = workbook.Sheets[sheetNames[0]]; // 这里我们只读取第一张sheet
    let csv = XLSX.utils.sheet_to_csv(worksheet);
    document.getElementById('result').innerHTML = csv2table(csv);
}
var a = [{"value":"0"}];
function csv2table(csv)
{
    let html = '';
    let rows = csv.split('\n');
    rows.pop(); // 最后一行没用的
    rows.forEach(function(row, idx) {
        let columns = row.split(',');
		if(idx==0){
        html += '<tr>';
        columns.forEach(function(column) {
            html += '<th>'+column+'</th>';
        });
        html += '</tr>';
		}
		else{
			var value = '<tr>';
			columns.forEach(function(column) {
			    value += '<td>'+column+'</td>';
			});
			value += '</tr>';
			var b = {"value":value};
			a.push(b);
		}
    });
    return html;
}

$(function() {
    document.getElementById('file').addEventListener('change', function(e) {
        let files = e.target.files;
        if(files.length == 0) return;
        let f = files[0];
        if(!/\.xlsx$/g.test(f.name)) {
            alert('仅支持读取xlsx格式！');
            return;
        }
        readWorkbookFromLocalFile(f, function(workbook) {
            readWorkbook(workbook);
				$("result").show();
			pagination(20, 1);
        });
    });
});

	//列表分页
	//perPage 每一页显示条数     current：当前第几页
	function pagination(perPage, current) {
		var tableData = a
		var totalCount = tableData.length-1; //总条数
	
		//设置表格总页数
		var totalPage = 0; //列表的总页数
		var pageSize = perPage;
		if (totalCount / pageSize > parseInt(totalCount / pageSize)) {
			totalPage = parseInt(totalCount / pageSize) + 1;
		} else {
			totalPage = parseInt(totalCount / pageSize);
		}
		//对数据进行分页
		var currentPage = current;
		var startRow = (currentPage - 1) * pageSize + 1;
		var endRow = (currentPage * pageSize > totalCount ? totalCount : currentPage * pageSize);
	    var html = "";
		for (var i = 1; i < (totalCount + 1); i++) {
			if (i >= startRow && i <= endRow) {
				html +=a[i].value;
			}
		}
		$("#tbody").html(html);
		html = "";
		//位置2 生成当前的点击按钮
		createBtns(totalPage, current);
		//位置3  绑定点击事件
		bindClick(totalPage);
	
	}
	//生成点击按钮
	//totalPages 分页的总页数
	//current当前页
	function createBtns(totalPages, current) {
		var tempStr = "";
		/*上一页按钮*/
		if (current > 1) {
			/* tempStr += "<span class='btn first' href=\"#\"  data-page = '1'>首页</span>";*/
			tempStr += "<span class='btn prev' href=\"#\" data-page = " + (current - 1) + ">上一页</span>"
		}
		/*中间页码的显示*/
		/*如果总页数超出5个处理办法*/
		if (totalPages <= 5) {
			for (var pageIndex = 1; pageIndex < totalPages + 1; pageIndex++) {
				tempStr += "<a  class='btn page" + pageIndex + "'  data-page = " + (pageIndex) + "><span>" + pageIndex +
					"</span></a>";
			}
		} else {
			if (current < 5) {
				for (var pageIndex = 1; pageIndex <= 5; pageIndex++) {
					tempStr += "<a  class='btn page" + pageIndex + "'  data-page = " + (pageIndex) + "><span>" + pageIndex +
						"</span></a>";
				}
				tempStr += '<span>......</span>';
				tempStr += "<a  class='btn page" + totalPages + "'  data-page = " + (totalPages) + "><span>" + totalPages +
					"</span></a>";
			} else if (current >= totalPages - 4) {
				tempStr += "<a  class='btn page" + 1 + "'  data-page = " + (1) + "><span>" + 1 + "</span></a>";
				tempStr += '<span>......</span>';
				for (var pageIndex = totalPages - 5; pageIndex <= totalPages; pageIndex++) {
					tempStr += "<a  class='btn page" + pageIndex + "'  data-page = " + (pageIndex) + "><span>" + pageIndex +
						"</span></a>";
				}
			} else if (current >= 5 && current < totalPages - 4) {
				tempStr += "<a  class='btn page" + 1 + "'  data-page = " + (1) + "><span>" + 1 + "</span></a>";
				tempStr += '<span>......</span>';
				for (var pageIndex = current; pageIndex <= current + 4; pageIndex++) {
					tempStr += "<a  class='btn page" + pageIndex + "'  data-page = " + (pageIndex) + "><span>" + pageIndex +
						"</span></a>";
				}
				tempStr += '<span>......</span>';
				tempStr += "<a  class='btn page" + totalPages + "'  data-page = " + (totalPages) + "><span>" + totalPages +
					"</span></a>";
			}
		}
		/*下一页按钮*/
		if (current < totalPages) {
			tempStr += "<span class='btn next' href=\"#\"  data-page = " + (current + 1) + ">下一页</span>";
			/*            tempStr += "<span class='btn last' href=\"#\" data-page = "+ (totalPages) +">尾页</span>";*/
		}
		document.getElementById("pageination").innerHTML = tempStr;
	}
	
	function bindClick(totalPage) {
		// 设置首页、末页、上一页、下一页的点击事件
		var buttonArr = ['first', 'last', 'prev', 'next'];
		for (var k in buttonArr) {
			var $dom = '.' + buttonArr[k];
			$('body').delegate($dom, 'click', function() {
				var data = $(this).data('page'); //获取当前按钮跳转的页数
				pagination('20', data); //对页面进行分页
				//对当前页码的样式做处理
				$('.page' + data).css({
					background: '#0449d4',
					color: '#fff'
				}).siblings().css({
					background: '#fff',
					color: '#999'
				});
			})
		}
	
		// 设置数码的点击事件 totalImgPage是总页数，为全局变量，在分页时被赋值
		for (var k = 1; k <= totalPage; k++) {
			var $singleDom = '.page' + k;
			$('body').delegate($singleDom, 'click', function() {
				var data = $(this).data('page');
				pagination('20', data); //对页面进行分页
				//对当前页码的样式做处理
				$('.page' + data).css({
					background: '#0449d4',
					color: '#fff'
				}).siblings().css({
					background: '#fff',
					color: '#999'
				});
			})
		}
	}

