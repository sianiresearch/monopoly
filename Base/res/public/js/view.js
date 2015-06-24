var min, max;

function refresh() {
	$(".region").remove();
	var main = $("body");
	min = calculateMin();
	max = calculateMax();
	for (var i = 0; i < board.length; i++) {
		main.append(region(i));
	}
}

function region(index) {
	var shade = shadeOf(heatmap[index]);
	var box = boxOf(board[index]);
	return createRegion(index, shade, box);
}

function shadeOf(value) {
	var shade = Math.floor(255 - ((value - min) / (max - min)) * 255);
	return  shade >= 0 ? shade : 0;
}

function boxOf(square) {
	var bg = {
		top: 0,
		left: 210,
		height: 510,
		width: 510
	}
	var box = {
		top: (square.top * bg.height) / 510.0 + bg.top,
		left: (square.left * bg.height) / 510.0 + bg.left,
		height: (square.height * bg.height) / 510.0,
		width: (square.width * bg.height) / 510.0
	}
	return box;
}

function createRegion(index, shade, box) {
	var color = "rgb(" + shade + "," + shade + ",255)";
	var element = $("<div/>").
			attr("id","s"+index).
			attr("class","region").
			css("background-color",color).
			offset({top:box.top,left:box.left}).height(box.height).width(box.width);
	return element;
}

function calculateMin() {
	var min = Number.MAX_VALUE;
	for (var i = 0; i < heatmap.length; i++) {
		min = Math.min(heatmap[i],min);
	}
	return min;
}

function calculateMax() {
	var max = 0;
	for (var i = 0; i < heatmap.length; i++) {
		if (i == 10) continue;
		max = Math.max(heatmap[i],max);
	}
	if (max == 0) max = 1;
	return max;
}

