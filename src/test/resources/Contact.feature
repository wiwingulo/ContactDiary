#Author: wiwingulo@gmail.com
Feature: Create New Contact

Scenario Outline: Add new Contact
	Given User berada di halaman MainActivity
	When User memasukkan username "Wiwin"
	And User memasukkan place "Medan"
	And User memasukkan date
	And User memasukkan phone "23432432"
	And User memilih relatif or close friend
	And User memilih encounter type
	And User mengisi notes "Halohalo"
	And User menekan tombol save
	Then User kembali ke menu MainActivity
	
