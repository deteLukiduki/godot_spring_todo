extends Control

var todo_path = "res://todo_item.tscn"
var todo_res = load(todo_path)

var post = false
var get = false
# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	$HTTPRequest.connect("request_completed", self, "_on_request_completed")
	requestTodos()
	
	$createPanel/OptionButton.add_item("0")
	$createPanel/OptionButton.add_item("1")
	$createPanel/OptionButton.add_item("2")
	$createPanel/OptionButton.add_item("3")
	$createPanel/OptionButton.add_item("4")

func requestTodos():
	get = true
	$HTTPRequest.request("http://localhost:8090/todos")

func _on_request_completed(result, response_code, headers, body):
	if get:
		var todos = JSON.parse(body.get_string_from_utf8())
		for todo in todos.result:
			var todoItem = todo_res.instance()
			todoItem.setText(todo.text)
			todoItem.setID(todo.id);
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
			get = false
	elif post:
		get_tree().reload_current_scene()
		post = false
		
		
	


func _on_Button_pressed():
	$createPanel.visible = true


func _on_Submit_pressed():
	$createPanel.visible = false
	var data = {
		text = $createPanel/TextEdit.text,
		priority = $createPanel/OptionButton.selected
	}
	var query = JSON.print(data)
	print(query)
	
	post = true
	var headers = ["Content-Type: application/json"]
	$HTTPRequest.request("http://localhost:8090/todos", headers, true, HTTPClient.METHOD_POST, query)


func _on_Cancel_pressed():
	$createPanel.visible = false
