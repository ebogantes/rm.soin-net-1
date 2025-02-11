var $csvForm = $('#csvForm');
$(function() {
	$('#configurationItemsTable').on('draw.dt', function() {
		$("#countObject").text($('#configurationItemsTable').DataTable().rows().count());
	});
});

function openCSVModal() {
	$("#addCSVModal #csvForm")[0].reset();
	$('#addCSVModal').modal('show');
}

function closeCSVModal() {
	$('#addCSVModal').modal('hide');
	$("#addCSVModal #csvForm")[0].reset();
}

function addRowObject(obj) {
	var table = $('#configurationItemsTable').DataTable();

	for (var i = 0; i < obj.length; i++) {
		table.row
		.add(
				[
					obj[i].name,
					obj[i].description,
					obj[i].revision_SVN,
					formatDateCustom(obj[i].revision_Date, '/'),
					$(
							"#addObjectItemModal #typeObject option[id='"
							+ obj[i].typeObject + "']")
							.text(),
							$(
									"#addObjectItemModal #itemConfiguration option[id='"
									+ obj[i].itemConfiguration
									+ "']").text(),
									'<div style="text-align: center"> <i onclick="deleteconfigurationItemsRow('
									+ obj[i].id
									+ ')" class="material-icons gris" style="font-size: 30px;">delete</i></div>' ])
									.node().id = obj[i].id;
		table.draw();

		if (obj[i].isSql == 1) {
			triggerDataBaseFile(obj[i].id, obj[i].name);
		}
	}
	closeCSVModal();
}

function uploadCSV() {
	if ($csvForm.find('#csv').val().length == 0
			|| $csvForm.find('#csv').val().trim() == "") {
		swal("Error!", "Ingrese un valor", "error")
		return false;
	}

	blockUI();
	var cont = getCont();
	var id = $('#generateReleaseForm #release_id').val();
	$.ajax({
		type : "POST",
		url : cont + "release/" + "uploadCSV/" + id,
		timeout : 300000,
		data : {
			csv : $csvForm.find('#csv').val(),
		},
		success : function(response) {
			responseAjaxSendReleaseCSV(response);
		},
		error : function(x, t, m) {
			notifyAjaxError(x, t, m);
		}
	});

}

function responseAjaxSendReleaseCSV(response) {
	switch (response.status) {
	case 'success':
		addRowObject(response.obj.objects);
		$.each(response.obj.dependencies, function(key, value) {
			modifyDependency(value.to_release);
		});
		swal("Correcto!", "CSV cargado correctamente.", "success", 2000)

		break;
	case 'fail':
		swalReport("Error!", response.exception, "error")
		break;
	case 'exception':
		swal("Exception!", response.exception, "error")
		break;
	default:
		unblockUI();
	}
}