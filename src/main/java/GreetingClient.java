import com.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient extends GreetServiceGrpc.GreetServiceImplBase {
    public static void main(String[] args) {
        System.out.println("Hello I am a gRPC client");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build(); //Transport
        GreetServiceGrpc.GreetServiceBlockingStub syncClient = GreetServiceGrpc.newBlockingStub(channel);
       Greeting greeting = Greeting.newBuilder().setFirstName("Alex").setLastName("Karamfilov").setAge(35).build();
        GreetRequest request = GreetRequest.newBuilder().setGreeting(greeting).build();
        GreetResponse response = syncClient.greet(request);
        System.out.println("Response:" + response.getResult());
        channel.shutdown();
    }
}
