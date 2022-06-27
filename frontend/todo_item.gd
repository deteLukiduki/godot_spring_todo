extends Control

var ID: int

func setID(ID: int):
	print(ID)
	self.ID = ID

func setText(var text):
	$TextEdit.text = text


func _on_Button_pressed():
	pass


func _on_CheckBox_pressed():
	print("done")
	var headers = ["Content-Type: application/json"]
	$HTTPDelete.request("http://localhost:8090/todos/" + String(ID), headers, true, HTTPClient.METHOD_DELETE)
