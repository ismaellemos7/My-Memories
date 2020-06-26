from django.contrib import admin
from .models import User, Address, Person, Administrador, Like, Comment
# Register your models here.

admin.site.register(User)
admin.site.register(Address)
admin.site.register(Person)
admin.site.register(Administrador)
admin.site.register(Like)
admin.site.register(Comment)