from django.db import models
from datetime import datetime
from django.utils import timezone


class Address(models.Model):
    public_place = models.CharField(max_length=20)
    number = models.IntegerField()
    complement = models.CharField(max_length=20, null=True, blank=True)
    neighborhood = models.CharField(max_length=20)
    city = models.CharField(max_length=20)
    state = models.CharField(max_length=20)
    country = models.CharField(max_length=20)
    postal_code = models.CharField(max_length=20)
    latitude = models.CharField(max_length=20, null=True, blank=True)
    longitude = models.CharField(max_length=20, null=True, blank=True)

class Person(models.Model):
    username = models.CharField(max_length=20)
    first_name = models.CharField(max_length=20)
    last_name = models.CharField(max_length=20)
    birth_date = models.DateField()
    phonenumber = models.CharField(max_length=15)
    address = models.ForeignKey(Address, null=True, blank=True, on_delete=models.CASCADE)

    def age(self):
        timezone.now().date - self.birth_date

class User(models.Model):
    person = models.OneToOneField(Person, on_delete=models.CASCADE)
    email = models.EmailField()
    password = models.CharField(max_length=255)
    active = models.BooleanField(default=True)

class Administrador(models.Model):
    person = models.OneToOneField(Person, on_delete=models.CASCADE)
    email = models.EmailField()
    password = models.CharField(max_length=255)
    active = models.BooleanField(default=True)

class Like(models.Model):
    date = models.DateField()
    users = models.ManyToManyField(User)

class Publication(models.Model):
    text = models.TextField(null=True, blank=True)
    image = models.ImageField(null=True, blank=True)
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    likes = models.ManyToManyField(Like)
    

    def likes(self):
        return len(likes)

class Comment(models.Model):
    text = models.TextField(null=True, blank=True)
    image = models.ImageField(null=True, blank=True)
    users = models.ManyToManyField(User)
    publication = models.ManyToManyField(Publication)
