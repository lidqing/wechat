;(function ($) {
    var App = {};
    //异步请求
    App.getAjaxData = function(url,param,callBack,errorCall){
        $.ajax({
            url:url,
            dataType:"json",
            data:param,
            success:function (data) {
                callBack(data);
            },
            error:function () {
                errorCall(arguments);
            }
        })
    }

    //滚动加载初始化
    App.infinite = function (target) {
        $(target).infinite();
        $(".weui-loadmore").css("display","");
        $(".weui-loadmore__tips").css("display","");
        $(".weui-nomore__tips").css("display","none");
    }
    //滚动加载数据达到最大的时候销毁
    App.destroyInfinite = function (target) {
        $(target).destroyInfinite();
        $(".weui-loadmore__tips").css("display","none");
        $(".weui-nomore__tips").css("display","");
        setTimeout(function () {
            $(".weui-loadmore").css("display","none");
        },1000);
    }

    //下拉刷新
    App.pullToRefresh = function (target,callBack) {
        $(target).pullToRefresh(function () {
            // 下拉刷新触发时执行的操作放这里。
            callBack();
            setTimeout(function () {
                $(target).pullToRefreshDone();//加载完成，重置刷新状态
            },1000);
        });
    }
    //滚动加载
    App.rollingLoad = function (target,callBack) {
        //滚动加载初始化并监听事件
        var loading = false;  //状态标记
        $(target).infinite().on("infinite", function() {
            if(loading) return;
            loading = true;
            callBack();
            setTimeout(function() {
                loading = false;
                //$(document.body).destroyInfinite();
                //$(document.body).infinite();
            }, 500);   //模拟延迟

        });
    }


    window.App = App;
})(jQuery);