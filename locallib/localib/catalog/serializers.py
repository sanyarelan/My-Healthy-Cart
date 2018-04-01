from rest_framework import serializers
from .models import Health,NutritionSuggestion


class NutritionSuggestionSerializer(serializers.ModelSerializer):
     
    class Meta:
        model = NutritionSuggestion
        fields = ('Fruits','Vegetables','Nuts','Dairy')
        
class HealthSerializer(serializers.ModelSerializer):
    class Meta:
        model = Health
        fields = ('Username','password','name','phonenumber','age','allergy','disease')
        