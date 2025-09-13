package taskloom.base;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class AuthFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification req,
                           FilterableResponseSpecification res,
                           FilterContext ctx) {
        boolean alreadySet = req.getHeaders().hasHeaderWithName("Authorization");
        String token = AuthContext.getToken();

        if (!alreadySet && token != null && !token.isBlank()) {
            req.header("Authorization", "Bearer " + token);
        }
        return ctx.next(req, res);
    }
}
