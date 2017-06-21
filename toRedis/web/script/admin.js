/**
 * Created by Zhan on 2017/6/12 0012.
 */
var blogAdmin = new Vue({
    el: '#blogAdmin',
    data: {
        seted:false,
        admin:''
    },
    methods: {
        getAdmin: function () {
            $.ajax({
                url: "/blog?action=getAdmin",
                success: function( result ) {
                    var result = JSON.parse(result);
                    if(result.name){
                        blogAdmin.admin = result.name;
                        blogAdmin.seted = true;
                    }
                }
            });
        },
        saveAdmin: function () {
            $.ajax({
                url: "/blog?action=setAdmin",
                data:{
                  admin: blogAdmin.admin
                },
                success: function( result ) {
                    blogAdmin.seted = true;
                }
            });
            this.seted = true;
        }
    }
});
blogAdmin.getAdmin();

