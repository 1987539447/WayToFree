/**
 * Created by Zhan on 2017/6/12 0012.
 */
var viewBlog = new Vue({
    el: '#viewBlog',
    data: {
        blog:{
            id:undefined,
            title:undefined,
            pubTime:undefined,
            content:undefined
        }
    },
    methods: {
        getBlog: function () {
            $.ajax({
                url: "/blog?action=view&postId=3",
                success: function( result ) {
                    viewBlog.blog = JSON.parse(result);
                }
            });
        },
    }
});
viewBlog.getBlog();

