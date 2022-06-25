extends Control

var todo_path = "res://todo_item.tscn"
var todo_res = load(todo_path)
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	$HTTPRequest.connect("request_completed", self, "_on_request_completed")
	$HTTPRequest.request("http://localhost:8090/todo")


func _on_request_completed(result, response_code, headers, body):
	var json = JSON.parse(body.get_string_from_utf8())
	if json:
		print(json.result)
		var todoItem = todo_res.instance()
		todoItem.setText(json.result.text)
		$HBoxContainer/priority1/VBoxContainer.add_child(todoItem)
		

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
