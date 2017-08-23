<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<link rel='dns-prefetch' href='//s.w.org' />
<link rel="canonical" href="https://c.runoob.com/compile/10" />
<meta name="keywords" content="Java 在线工具">
<meta name="description" content="在编辑器上输入简单的 Java 代码，可在线编译运行。..">
<!-- jQuery -->
<script src="//cdn.bootcss.com/jquery/2.0.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/codemirror/5.25.0/codemirror.min.js"></script>
<link rel="stylesheet"
	href="//cdn.bootcss.com/codemirror/5.25.0/codemirror.min.css">
<script src="//cdn.bootcss.com/codemirror/5.25.0/mode/clike/clike.js"></script>
<!-- Bootstrap Core CSS -->
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="/wp-content/themes/toolrunoob/startbootstrap/css/modern-business.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/wp-content/themes/toolrunoob/assets/font-awesome-4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="/wp-content/themes/toolrunoob/style.css?version=1.02">




<style type="text/css">
.CodeMirror {
	height: 374px;
}
</style>
</head>
<body>
	<c:import url="head.jsp" />
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div id="compiler" class="panel-heading">
						<form class="form-inline" role="form">
							<button type="button" class="btn btn-success" id="submitBTN"
								style="margin-right: 12px;" disabled="disabled">
								<i class="fa fa-send-o"></i> 点击运行
							</button>
						</form>
					</div>
					<div class="panel-body">
						<form role="form" id="compiler-form">
							<div class="form-group">
								<div class="row">
									<div class="col-md-7">
										<textarea class="form-control" id="code" name="code" rows="18">public class HelloWorld {
    public static void main(String []args) {
       System.out.println("Hello World!");
    }
}</textarea>
									</div>
									<div class="col-md-5">
										<textarea placeholder="运行结果……" class="form-control"
											id="compiler-textarea-result" rows="18">Hello World!</textarea>
									</div>
								</div>
							</div>


						</form>
					</div>
				</div>
			</div>

		</div>
<script>
var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
	lineNumbers: true,
	matchBrackets: true,
	mode: "text/x-java",
	indentUnit: 4,
	indentWithTabs: true,
});
btn = $("#submitBTN");
editor.on("change",function(editor,change){
	btn.prop('disabled', false);
});
btn.click(function() {
	btn.prop('disabled', true);
	loadingdata = '程序正在运行中……';
	$("#compiler-textarea-result").val(loadingdata);
  
	code = editor.getValue();
	runcode = 8;
	$.post("https://m.runoob.com/api/compile.php",{code:code,language:runcode},function(data){
		if(runcode==18) {
			data.output = data.output.replace("Free Pascal Compiler version 2.6.2-8 [2014/01/22] for x86_64\nCopyright (c) 1993-2012 by Florian Klaempfl and others\n", "");
			data.errors = data.errors.replace("/usr/bin/ld.bfd: warning: /usercode/link.res contains output sections; did you forget -T?\n", "");
		}
		$("#compiler-textarea-result").val(data.output + data.errors);
	});
	setTimeout(function(){
        btn.prop('disabled', false);
    }, 10*1000);
});

$(function(){
  // bind change event to select
  $('#sel1').on('change', function () {
      var url = $(this).val(); // get selected value
      if (url) { // require a URL
          window.location = url; // redirect
      }
      return false;
  });
});

</script>



	</div>
	<div style="display: none;">
		<script>
			var _hmt = _hmt || [];
			(function() {
				var hm = document.createElement("script");
				hm.src = "https://hm.baidu.com/hm.js?68c6d4f0f6c20c5974b17198fa6fd40a";
				var s = document.getElementsByTagName("script")[0];
				s.parentNode.insertBefore(hm, s);
			})();
		</script>

	</div>
	<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>