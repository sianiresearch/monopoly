var interval

$( document ).ready(function() {
	initToolbar();
	refresh();
	window.onresize = function() {
		refresh();
	}
});

function initToolbar() {
	$("#pause").hide();
	$("#play").click(function() {
		$.get("/control/play", function(data) {
			if (data != "OK") return;
			$("#play").hide();
			$("#pause").show();
			interval = setInterval(reload, 100);
		});
		return false;
	});
	$("#pause").click(function() {
		$.get("/control/pause", function(data) {
			if (data != "OK") return;
			$("#play").show();
			$("#pause").hide();
            clearInterval(interval);
		});
		return false;
	});
}

function reload() {
    $.get("/query/heatmap.js", function( data ) {
		eval(data);
    	console.log(heatmap[2]);
		refresh();
	});
}

