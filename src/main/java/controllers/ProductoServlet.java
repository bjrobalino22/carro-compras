package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Productos;
import service.LoginService;
import service.LoginServiceSessionImplement;
import service.ProductoService;
import service.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService servicios = new ProductoServiceImplement();
        List<Productos> productos = servicios.listar();

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            // Comenzamos a construir el HTML con Bootstrap
            out.print("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Listado de Productos</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container mt-5\">");
            out.println("<h1 class=\"mb-4\">Listado de Productos</h1>");
            if (usernameOptional.isPresent()) {
                out.println("<div class=\"alert alert-success\">Hola " + usernameOptional.get() + ", ¡bienvenido!</div>");
            } else {
                out.println("<div class=\"alert alert-info\">Bienvenido, visitante. Por favor, <a href=\"" + req.getContextPath() + "/login.jsp\">inicia sesión</a> para ver precios y agregar productos al carro.</div>");
            }
            out.println("<table class=\"table table-bordered\">");
            out.println("<thead class=\"thead-light\">");
            out.println("<tr>");
            out.println("<th>ID PRODUCTO</th>");
            out.println("<th>NOMBRE</th>");
            out.println("<th>CATEGORÍA</th>");
            if (usernameOptional.isPresent()) {
                out.println("<th>PRECIO</th>");
                out.println("<th>AGREGAR</th>");
            }
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            productos.forEach(pr -> {
                out.println("<tr>");
                out.println("<td>" + pr.getIdProducto() + "</td>");
                out.println("<td>" + pr.getNombre() + "</td>");
                out.println("<td>" + pr.getCategoria() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("<td>$" + pr.getPrecio() + "</td>");
                    out.println("<td><a href=\"" + req.getContextPath() + "/agregar-carro?idProducto=" + pr.getIdProducto() + "\" class=\"btn btn-primary btn-sm\">Agregar al carro</a></td>");
                }
                out.println("</tr>");
            });
            out.println("</tbody>");
            out.println("</table>");
            out.println("<div class=\"mt-4\">");
            out.println("<a href=\"" + req.getContextPath() + "/index.html\" class=\"btn btn-secondary\">Volver al inicio</a>");
            if (usernameOptional.isPresent()) {
                out.println("<a href=\"" + req.getContextPath() + "/ver-carro\" class=\"btn btn-success ml-2\">Ver Carro</a>");
            }
            out.println("</div>");
            out.println("</div>");
            out.println("<!-- Scripts de Bootstrap y dependencias -->");
            out.println("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

