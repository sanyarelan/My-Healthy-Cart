from django.contrib import admin

from .models import Health
from .models import NutritionSuggestion
admin.site.register(Health)
admin.site.register(NutritionSuggestion)