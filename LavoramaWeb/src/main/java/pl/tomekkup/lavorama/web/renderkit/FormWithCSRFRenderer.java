package pl.tomekkup.lavorama.web.renderkit;

import com.sun.faces.renderkit.html_basic.FormRenderer;
import lombok.extern.slf4j.Slf4j;

import jakarta.el.ELContext;
import jakarta.el.ExpressionFactory;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseWriter;
import java.io.IOException;

@Slf4j
public class FormWithCSRFRenderer extends FormRenderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        //log.debug("FormWithCSRFRenderer - Adding CSRF Token to form element");
        ELContext elContext = context.getELContext();
        ExpressionFactory expFactory = context.getApplication().getExpressionFactory();

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("input", component);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("name", expFactory.createValueExpression(elContext, "${_csrf.parameterName}", String.class).getValue(elContext), null);
        writer.writeAttribute("value", expFactory.createValueExpression(elContext, "${_csrf.token}", String.class).getValue(elContext), null);
        writer.endElement("input");
        writer.write("\n");
        super.encodeEnd(context, component);
    }
}