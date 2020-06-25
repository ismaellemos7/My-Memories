from rest_framework import serializers
from mymemories_app.models import User, Person, Address

class AddressSerializer(serializers.ModelSerializer):

    class Meta:
        model = Address
        fields = ('__all__')

class PersonSerializer(serializers.ModelSerializer):

    address = AddressSerializer(many=False, read_only=True)

    class Meta:
        model = Person
        fields = ('__all__')

class UserSerializer(serializers.ModelSerializer):

    person = PersonSerializer(many=False, read_only=True)

    extra_kwargs = { 'password': { 'write_only': True } }

    class Meta:
        model = User
        fields = ('__all__')