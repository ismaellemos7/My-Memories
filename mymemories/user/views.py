from django.shortcuts import render
from mymemories_app import models
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
import json
from .serializers import UserSerializer, PersonSerializer
from django.http import JsonResponse

class Users(APIView):

    def post(self, request):
        req = json.loads(request.body)

        if 'first_name' not in req or 'last_name' not in req or 'birth_date' not in req or 'phonenumber' not in req:
            return Response(status=status.HTTP_400_BAD_REQUEST)

        person = models.Person.objects.create(
            first_name = req['fisrt_name'],
            last_name = req['last_name'],
            birth_date = req['birth_date'],
            phonenumber = req['phonenumber']
        )

        models.User.objects.create(
            person = person,
            email = req['email'],
            password = req['password'],
            active = True
        )
        return Response(status=status.HTTP_200_OK)

    def get(self, request):
        # req = json.loads(request.body)
        # users = None
        # if 'id' in req:
        #     id = req['id']
        #     users = models.User.objects.filter(pk=id, ativo=True)
            
        # if not users.exist():
        #     raise Exception('Não existe Usuario cadastrado')

        
        json_data = UserSerializer(
            models.User.objects.filter(active=True), many=True
        )
        return JsonResponse(json_data.data, safe=False, status=status.HTTP_200_OK)

    def put(self, request):
        req = json.loads(request.body)
        id = None
        if 'id' in req:
            id = req['id']
        user = models.User.objects.filter(id = id)

        if not user.exists():
            raise Exception('Usuário não existe')
        user = user.last()
        return Response(status=status.HTTP_200_OK)

    def delete(self, request):
        req = json.loads(request.body)
        id = None
        if 'id' in req:
            id = req['id']

        user = models.User.objects.filter(id = id)
        
        if not user.exists():
            raise Exception('Usuário não existe')
        user = user.last()
        user.active = False
        user.save(update_fields=['active'])
        return Response(status=status.HTTP_200_OK)
        



        






