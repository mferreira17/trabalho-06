package interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptadora implements Serializable {
	
	@AroundInvoke
	public Object inceptor(InvocationContext ctx) throws Exception {
		System.out.println("INCLUINDO PESSOAS FROM LOG...");
		return ctx.proceed();
	}

}
