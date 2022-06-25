extends Control

var todo_path = "res://todo_item.tscn"

# Declare member variables here. Examples:
# var a = 2
# var b = "text"


# Called when the node enters the scene tree for the first time.
func _ready():
	var todo_res = load(todo_path)
	var todoItem = todo_res.instance()
	$HBoxContainer/priority1/VBoxContainer.add_child(todoItem)


# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
