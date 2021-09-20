import com.proto.GreetRequest;
import com.proto.GreetResponse;
import com.proto.GreetServiceGrpc;
import com.proto.Greeting;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        //Extract the fields
        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();
        String lastName = greeting.getLastName();
        int age = greeting.getAge();
        GreetResponse response = GreetResponse.newBuilder().setResult("Hello " + firstName + " " + lastName + " " + age).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
