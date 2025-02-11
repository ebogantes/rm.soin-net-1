<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="modal fade" id="typeRequestModal" tabindex="-1"
	role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="largeModalLabel">Tipo requerimiento</h4>
			</div>
			<div class="modal-body">
				<div class="row clearfix">
					<form id="typeRequestModalForm" action="">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="hidden"
							id="typeRequestId" value="" />
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<label for="name">C�digo</label>
							<div class="form-group">
								<div class="form-line">
									<input type="text" class="form-control" id="tCode"
										maxlength="50" name="tCode" placeholder="Ingrese un nombre"
										style="height: 60px;">
									<div class="help-info">M�x. 50 caracteres</div>
								</div>
							</div>
						</div>
						<div
							class="col-lg-12 col-md-12 col-sm-12 col-xs-12 m-t--20 m-b--20">
							<label for="description">Descripci�n</label>
							<div class="form-group">
								<div class="form-line">
									<input type="text" class="form-control" id="tDescription"
										name="tDescription" placeholder="Ingrese un nombre"
										style="height: 60px;">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default waves-effect"
					onclick="closeTypeRequest()">CANCELAR</button>
				<button id="save" type="button" class="btn btn-primary waves-effect"
					onclick="saveTypeRequest()">GUARDAR</button>
				<button id="update" type="button"
					class="btn btn-primary waves-effect" onclick="updateTypeRequest()">ACTUALIZAR</button>
			</div>
		</div>
	</div>
</div>
