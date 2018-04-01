from django.db import models
from django.contrib.postgres.fields import ArrayField

class Health(models.Model):
    # Fields
    Username = models.EmailField(max_length = 20, help_text = "Enter your email id")
    password = models.CharField(null = True,max_length = 20,help_text = "Should consist of alphabets and digits")
    name = models.CharField(null = True,max_length = 20,help_text="Enter your name :")
    phonenumber = models.IntegerField(default = 1,help_text="Enter your phonenumber :")
    age = models.IntegerField(default = 1,help_text="Enter your age :")
    allergy = models.TextField(null = True,max_length=20, help_text="Enter your allergy :")
    disease = models.TextField(null = True,max_length=20, help_text="Enter the disease :")
    
    class Meta:
        ordering = ["-Username"]
    
    def __str__(self):
        return self.Username
    
    

class NutritionSuggestion(models.Model):
      Allergy = models.CharField(null = True,max_length = 20)
      Disease = models.CharField(null = True,max_length = 20)
      Fruits = ArrayField(models.TextField(null = True, max_length = 20))
      Vegetables = ArrayField(models.TextField(default = "0",null = True, max_length = 20))
      Dairy = ArrayField(ArrayField(models.TextField(default = "",max_length = 20,blank = True),default = list,null = True))
      Nuts = ArrayField(ArrayField(models.TextField(default = "", max_length = 20,blank = True),default = list,null = True))
      
      class Meta:
        ordering = ["-Allergy"]
        
      def __str__(self):
        return self.Allergy

    

