package controllers;
 
import java.text.ParseException;
import java.util.List;

import models.ControlaMetas;
import models.Meta;
import play.data.Form;
import play.data.validation.ValidationError;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
 
public class Application extends Controller {
 
	private static ControlaMetas gerenciador = new ControlaMetas();
	private static final Form<Meta> metaForm = Form.form(Meta.class);
 

 
 
	public static Result novaMeta() throws ParseException {
 
		List<Meta> result = gerenciador.getDao().findAllByClassName("Meta");
 
		Form<Meta> filledForm = metaForm.bindFromRequest();
		Meta meta = filledForm.get();
		if (filledForm.hasErrors()) {

			String errorMsg = "";
            java.util.Map<String, List<play.data.validation.ValidationError>> errorsAll = filledForm.errors();
            for (String field : errorsAll.keySet()) {
                errorMsg += field + " ";
                for (ValidationError error : errorsAll.get(field)) {
                    errorMsg += error.message() + ", ";
                }
            }
            flash("error", "Please correct the following errors: " + errorMsg);
			return badRequest(detail.render(filledForm));

		} else {
			gerenciador.getDao().persist(filledForm.get());
			gerenciador.getDao().flush();
			return redirect(routes.Application.listaMetas());
		}
	}
 

 
}