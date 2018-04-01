from rest_framework import permissions

class createOrLogin(permissions.IsAuthenticated):
    def has_permission(self,request,view):
        if request.method == 'POST':
               return True
        return super(createOrLogin,self).has_permission(request,view)