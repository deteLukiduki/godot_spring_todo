extends Control

var todo_path = "res://todo_item.tscn"
var todo_res = load(todo_path)
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	$HTTPRequest.connect("request_completed", self, "_on_request_completed")
	$HTTPRequest.request("http://localhost:8090/todos")


func _on_request_completed(result, response_code, headers, body):
	var todos = JSON.parse(body.get_string_from_utf8())
	
	for todo in todos.result:
		print(todo)
		var todoItem = todo_res.instance()
		todoItem.setText(todo.text)
		print(todo.priority)
		var priority: int = todo.priority
		
		match priority:
			1:
				$HBoxContainer/priority1/VBoxContainer.add_child(todoItem)
			2: 
				$HBoxContainer/priority2/VBoxContainer.add_child(todoItem)
			3: 
				$HBoxContainer/priority3/VBoxContainer.add_child(todoItem)
			4:
				$HBoxContainer/priority4/VBoxContainer.add_child(todoItem)
			_:
				$HBoxContainer/priority5/VBoxContainer.add_child(todoItem)

# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
