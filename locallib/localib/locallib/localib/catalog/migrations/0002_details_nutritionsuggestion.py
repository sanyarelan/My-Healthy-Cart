# Generated by Django 2.0.3 on 2018-04-01 00:19

import django.contrib.postgres.fields
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('catalog', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='details',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(help_text='Enter your name :', max_length=20)),
                ('phonenumber', models.CharField(help_text='Enter your phonenumber :', max_length=20)),
                ('age', models.CharField(help_text='Enter your age :', max_length=20)),
                ('allergy', models.CharField(help_text='Enter your allergy :', max_length=20)),
                ('disease', models.CharField(help_text='Enter the disease :', max_length=20)),
            ],
            options={
                'ordering': ['-phonenumber'],
            },
        ),
        migrations.CreateModel(
            name='NutritionSuggestion',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('Allergy', models.CharField(max_length=20)),
                ('Disease', models.CharField(max_length=20)),
                ('Fruits', django.contrib.postgres.fields.ArrayField(base_field=models.TextField(max_length=20), size=None)),
                ('Vegetables', django.contrib.postgres.fields.ArrayField(base_field=models.TextField(max_length=20), size=None)),
            ],
            options={
                'ordering': ['-Allergy'],
            },
        ),
    ]
