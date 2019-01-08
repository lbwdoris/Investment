
(function() {
    var __juandatools = {
        paginator:function (data,func,isToTop,speed,name) {
            var n = "pagination";
            if (name != null) {
                n = name;
            }
            function istotop() {
                if(isToTop){
                    if(isNaN(speed)){
                        $('body,html').animate({scrollTop:0},speed);
                    }else {
                        $('body,html').animate({scrollTop:0},200);
                    }

                }
            }
            var pagination;
            if(!($('#'+n).length && $('#'+n).length>0)){
                pagination = $('<div></div>');
                pagination.attr("id",n);
                pagination.attr("class","pagination");
                pagination.appendTo("body");
            }else {
                $('#'+n).empty();
                pagination = $('#'+n);
            }
            pagination = $('#'+n);
            $('#'+n).empty();
            if(data.lastPage>1){
                $('#'+n).empty();
                var preSpan = $('<span></span>');
                preSpan.addClass("pg-item");
                preSpan.attr("data-page-num","pre");
                preSpan.html("PREV");
                if(window.innerWidth<500){
                    preSpan.html("<i class='fa fa-chevron-left' aria-hidden='true'></i>");
                }
                if(data.hasPreviousPage){
                    preSpan.click(function () {
                        if($.isFunction(func)){
                            func(data.prePage);
                            istotop();
                        }else {
                            console.error("不是一个方法");
                        }
                    });
                }else {
                    preSpan.addClass("disabled");
                }
                pagination.append(preSpan);
                var fistnum = data.firstPage;
                if(window.innerWidth<500){
                    var pre=null,page=null,next=null;
                    page=data.pageNum;
                    if(data.hasPreviousPage){
                        pre=data.prePage;
                        fistnum=pre;
                    }else {
                        fistnum=0;
                    }
                    if(data.hasNextPage){
                        next=data.nextPage;
                    }
                    data.navigatepageNums = [pre,page,next];
                }
                $.each(data.navigatepageNums,function (k,getpageNums){
                    if(getpageNums!=null){
                        var pageNumSpan = $('<span></span>');
                        pageNumSpan.addClass("pg-item");
                        pageNumSpan.attr("data-page-num",getpageNums);
                        pageNumSpan.html(getpageNums);
                        pageNumSpan.click(function () {
                            if($.isFunction(func)){
                                func(getpageNums);
                                istotop();
                            }else {
                                console.error("不是一个方法");
                            }
                        });
                        if((k+fistnum)==data.pageNum){
                            pageNumSpan.addClass("curr disabled");
                        }
                        pagination.append(pageNumSpan);
                    }
                });
                var nextSpan = $('<span></span>');
                nextSpan.addClass("pg-item");
                nextSpan.attr("data-page-num","next");
                nextSpan.html("NEXT");
                if(window.innerWidth<500){
                    nextSpan.html("<i class='fa fa-chevron-right' aria-hidden='true'></i>");
                }
                if(data.hasNextPage){
                    nextSpan.click(function () {
                        if($.isFunction(func)){
                            func(data.nextPage);
                            istotop();
                        }else {
                            console.error("不是一个方法");
                        }
                    });
                }else {
                    nextSpan.addClass("disabled");
                }
                pagination.append(nextSpan);
                var allPageCountSpan = $('<span></span>');
                allPageCountSpan.addClass("pg-total");
                allPageCountSpan.html("TOTAL "+data.pages+" PAGES");
                pagination.append(allPageCountSpan);
            }else {
                $('#'+n).empty();
            }
        }
    };
    window.JUANDATOOLS = __juandatools;
})();

