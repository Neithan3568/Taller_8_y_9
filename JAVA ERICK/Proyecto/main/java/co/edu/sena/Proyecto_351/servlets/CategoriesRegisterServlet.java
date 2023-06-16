package co.edu.sena.Proyecto_351.servlets;

import co.edu.sena.Proyecto_351.model.Category;
import co.edu.sena.Proyecto_351.repository.CategoryRepositoryImpl;
import co.edu.sena.Proyecto_351.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/registerCategory"})
public class CategoriesRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all form data
        String category_name = request.getParameter("category_name");

        // Fill it up in a Category object
        Category category = new Category();
        category.setCategory_name(category_name);

        // Call repository layer and save the category object to DB
        Repository<Category> repository = new CategoryRepositoryImpl();
        try {
            int rows = repository.saveObj(category);

            if (rows == 0) {
                System.out.println("Ocurrió un error al guardar la categoría");
            } else {
                System.out.println("Registro exitoso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Write the message back to the page in client browser
        String message = "Registro exitoso"; // or "Ocurrió un error al guardar la categoría"
        response.getWriter().write(message);
    }
}
