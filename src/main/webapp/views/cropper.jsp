<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="A complete example of Cropper.">
  <meta name="keywords" content="HTML, CSS, JS, JavaScript, jQuery, PHP, image cropping, web development">
  <meta name="author" content="Fengyuan Chen">
  <title>Crop Avatar - Cropper</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/cropper.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ImgCutCss/main.css">
	
  <script src="${pageContext.request.contextPath}/js/ImgCutJs/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/ImgCutJs/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/ImgCutJs/cropper.min.js"></script>
  <script src="${pageContext.request.contextPath}/js/ImgCutJs/main.js"></script>
  
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
  <div class="container" id="crop-avatar">

    <!-- Current avatar -->
    <div class="avatar-view" title="Change the avatar">
      <img src="${pageContext.request.contextPath}/images/B0.jpg" alt="Avatar">
    </div>
    <!-- Cropping modal -->
    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <form class="avatar-form" action="/uploadHeadImage" enctype="multipart/form-data" method="post" accept="image/*">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title" id="avatar-modal-label">更改封面</h4>
            </div>
            <div class="modal-body">
              <div class="avatar-body">

                <!-- avatar_file(源文件),avatar_data(裁剪参数JSON[x,y,w,h]),avatar-src(源文件路径) -->
                <div class="avatar-upload">
                  <input type="hidden" class="avatar-src" name="avatar_src">
                  <input type="hidden" class="avatar-data" name="avatar_data">
                  <label for="avatarInput" class="btn btn-primary">选择图片</label>
                  <input type="file" class="avatar-input" id="avatarInput" name="avatar_file" style="display: none;" accept="image/*">
                </div>

                <!-- Crop and preview -->
                <div class="row">
                  <div class="col-md-9">
                    <div class="avatar-wrapper"></div>
                  </div>
                  <div class="col-md-3">
                    <div class="avatar-preview preview-lg"></div>
                    <div class="avatar-preview preview-md"></div>
                    <div class="avatar-preview preview-sm"></div>
                  </div>
                </div>

                <div class="row avatar-btns">
                  <div class="col-md-9">
                    <div class="btn-group">
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="90" title="Rotate 90 degrees">旋转图片</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="15">15deg</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="30">30deg</button>
                      <button type="button" class="btn btn-primary" data-method="rotate" data-option="45">45deg</button>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <button type="submit" class="btn btn-primary btn-block avatar-save">提交</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div> -->
          </form>
        </div>
      </div>
    </div><!-- /.modal -->
    <!-- Loading state -->
    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
  </div>
</body>
</html>
