<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>热词分析</title>

<link rel="stylesheet" type="text/css" href="css/left-side-menu.css">
<link rel="stylesheet" type="text/css" href="font/iconfont.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="js/left-side-menu.js"></script>

</head>
<body>

<div class ="top"  style="width: 100%;height: 80px;background-color: #397bc5;text-align:center">
<br>
<p> <h2><span style="color:blue;font-weight:bold;">信息领域相关热词分析系统</span></h2> </p>
</div>
<div style="text-align:center;float:right;width:1090px;border: 0px;padding: 0px;margin: 0px">
<iframe id="ifrweb"  src="right.html" scrolling="auto"  frameborder="0" style="height:600px;width:1040px"  >
</iframe>
</div>
<div class="left-side-menu" >
    <div class="lsm-expand-btn">
        <div class="lsm-mini-btn">
            <label>
                <input type="checkbox" checked="checked">
                <svg viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                    <circle cx="50" cy="50" r="30" />
                    <path class="line--1" d="M0 40h62c18 0 18-20-17 5L31 55" />
                    <path class="line--2" d="M0 50h80" />
                    <path class="line--3" d="M0 60h62c18 0 18 20-17-5L31 45" />
                </svg>
            </label>

        </div>

    </div>
    <div class="lsm-container">
        <div class="lsm-scroll" >
            <div class="lsm-sidebar">
                <ul>
                    <li class="lsm-sidebar-item">
                        <a href="javascript:;"><i class="my-icon lsm-sidebar-icon icon_1"></i><span>热词图</span><i class="my-icon lsm-sidebar-more"></i></a>
                        <ul>
                            <li><a href="javascript:void(0);" onclick ="rengongzhineng()"><span>人工智能</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="qukuailian()"><span>区块链</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="dashuju()"><span>大数据</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="hulianwang()"><span>互联网+</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="zhihuichengshi()"><span>智慧城市</span></a></li>
          
                           
                        </ul>
                    </li>
                    <li class="lsm-sidebar-item">
                        <a href="javascript:;"><i class="my-icon lsm-sidebar-icon icon_2"></i><span>关系图</span><i class="my-icon lsm-sidebar-more"></i></a>
                        <ul>
                            <li><a href="javascript:void(0);" onclick ="zifuyun()"><span>字符云</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="guanxitu()"><span>关系图</span></a></li>
                            <li><a href="javascript:void(0);" onclick ="dayin()"><span>打印数据</span></a></li>
                        </ul>
                    </li>
                    <li class="lsm-sidebar-item">
                        <a href="javascript:;"><i class="my-icon lsm-sidebar-icon icon_2"></i><span>搜索</span><i class="my-icon lsm-sidebar-more"></i></a>
                        <ul>
                            <li><a href="javascript:void(0);" onclick ="chaxun()"><span>关键字查询</span></a></li>
                        </ul>
                    </li>
                    
                </ul>
                
            </div>
        </div>
        
    </div>

</div>
<script>
      	function rengongzhineng(){
      		
      		var ifrweb = document.getElementById("ifrweb");
    		var URL = "rengongzhineng.jsp";
    		ifrweb.src = URL;
      		 
      	}
		function zifuyun(){
      		
      		var ifrweb = document.getElementById("ifrweb");
    		var URL = "zifuyun.jsp";
    		ifrweb.src = URL;
      		 
      	}
		function guanxitu(){
      		
      		var ifrweb = document.getElementById("ifrweb");
    		var URL = "guanxitu.jsp";
    		ifrweb.src = URL;
      		 
      	}
		function dayin(){
      		
      		var ifrweb = document.getElementById("ifrweb");
    		var URL = "dayin.jsp";
    		ifrweb.src = URL;
      		 
      	}
		function dashuju(){
      		
      		var ifrweb = document.getElementById("ifrweb");
    		var URL = "dashuju.jsp";
    		ifrweb.src = URL;
      		 
      	}
		function qukuailian(){
		
			var ifrweb = document.getElementById("ifrweb");
			var URL = "qukuailian.jsp";
			ifrweb.src = URL;
		 
		}
		function chaxun(){
			
			var ifrweb = document.getElementById("ifrweb");
			var URL = "chaxun.jsp";
			ifrweb.src = URL;
		 
		}
		function hulianwang(){
			
			var ifrweb = document.getElementById("ifrweb");
			var URL = "hulianwang.jsp";
			ifrweb.src = URL;
		 
		}
		function zhihuichengshi(){
			
			var ifrweb = document.getElementById("ifrweb");
			var URL = "zhihuichengshi.jsp";
			ifrweb.src = URL;
		 
		}
</script>

</body>
</html>