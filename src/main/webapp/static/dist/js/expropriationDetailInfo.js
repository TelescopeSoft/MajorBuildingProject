
var areaCode1 = '320211'
var ieFlag=  $.support.leadingWhitespace;//定义判断IE8的变量
var domainurl='http://222.190.131.9:2280/zd'

//批前
function checkView(that,pk,fileid1,pubType){
	if(fileid1!=undefined && fileid1.length>0){
		if(!ieFlag){//IE8以下
			   //alert("您的IE浏览器版本过低无法预览，文档将直接下载至本地。");
				downloadFj1(that,fileid1);
			}else{
			   //IE8以上
				pdfShow(fileid1);
			}
	}else{
		window.open(domainurl+"/xxgkController/goToDetail.do?ggid="+pk+"&gklx="+pubType+"&unitCode="+areaCode1);
	}
}

//批复文件详情页面
function checkReplyFile(id,title){
	//$("#myReplyFile").attr('href','http://www.jsmlr.gov.cn/gtxxgk/nrglIndex.action?type=2&messageID='+id);
	//window.open("http://zrzy.jiangsu.gov.cn/gtxxgk/nrglIndex.action?type=2&messageID="+id);
	var url='http://zrzy.jiangsu.gov.cn/gtxxgk/nrgl/nrglIndexNew.action?type=2&messageID='+id+'&title='+title
	url=url.replace(/\(/g,"（").replace(/\)/g,"）")
	window.open(url);
}

//批中
function checkView1(that,pk,fileid1,pubType){
	if(fileid1!=undefined && fileid1.length>0){
		if(!ieFlag){//IE8以下
			   //alert("您的IE浏览器版本过低无法预览，文档将直接下载至本地。");
				downloadFj1(that,fileid1);
			}else{
			   //IE8以上
				pdfShow(fileid1);
			}
	}else{
		window.open(domainurl+"/xxgkController/goToDetail.do?ggid="+pk+"&gklx="+pubType+"&unitCode="+areaCode1);
	}
}

//批后
function checkView2(that,pk,fileid1,pubType){
	if(fileid1!=undefined && fileid1.length>0){
		if(!ieFlag){//IE8以下
			  // alert("您的IE浏览器版本过低无法预览，文档将直接下载至本地。");
				downloadFj1(that,fileid1);
			}else{
			   //IE8以上
				pdfShow(fileid1);
			}
	}else{
		window.open(domainurl+"/xxgkController/goToDetail.do?ggid="+pk+"&gklx="+pubType+"&unitCode="+areaCode1);
	}
}

//预览PDF
function pdfShow(fileid1){
	if(fileid1==undefined || fileid1.length<=0){
		alert("文件无效，无法预览！");
		return;
	}
	window.open(domainurl+"/xxgkController/pdfShow.do?fileid="+fileid1);
}

//下载附件
function downloadFj1(that,fileid1){
	$(that).attr("href",domainurl+"/xxgkController/downloadFj.do?fileid="+fileid1);
	$(that).click();
}
