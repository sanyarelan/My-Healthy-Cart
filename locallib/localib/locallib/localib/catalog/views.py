from django.shortcuts import render
from .models import Health,NutritionSuggestion
from .serializers import HealthSerializer,NutritionSuggestionSerializer
from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from rest_framework import viewsets,generics
from django.http import HttpResponse
from django.contrib.auth.models import User



# foodlist/
class HealthList(APIView):
    
     def get(self,request):
         nutrition = NutritionSuggestion.objects.filter(allergy__contains = '')
         nut = nutrition.objects.filter(disease__contains ='')
         serializer = NutritionSuggestionSerializer(nut,many = True)
         return Response(serializer.data)
    
     def post(self):
         pass

class HealthView(viewsets.ModelViewSet):
    queryset = Health.objects.all()
    serializer = HealthSerializer
    
    def register(self,request):
        serializer = HealthSerializer(data = request.DATA)
        if serializer.is_valid():
            user = User.objects.create_user(
                    Username = serializer.init_data['username'],
                    password = serializer.init_data['password'],
                    name = serializer.init_data['name'],
                    phonenumber = serializer.init_data['phone'],
                    age = serializer.init_data['age'],
                    allergy = serializer.init_data['allergy'],
                    disease = serializer.init_data['disease'],
                    
                    )
    
    
