extends Control

var ID: int

func setID(ID: int):
	print(ID)
	self.ID = ID

func setText(var text):
	$TextEdit.text = text

func _ready():
	$HTTPDelete.connect("request_completed", self, "_on_request_completed")
	
func _on_request_completed(result, response_code, headers, body):
	get_tree().reload_current_scene()

func _on_Button_pressed():
	pass


func _on_CheckBox_pressed():
	print("done")
	var headers = ["Content-Type: application/json"]
	$HTTPDelete.request("http://localhost:8090/todos/" + String(ID), headers, true, HTTPClient.METHOD_DELETE)
