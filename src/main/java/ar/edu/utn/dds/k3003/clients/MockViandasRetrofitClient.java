package ar.edu.utn.dds.k3003.clients;

import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import okhttp3.Request;
import okio.Timeout;

import java.time.LocalDateTime;

public class MockViandasRetrofitClient implements ViandasRetrofitClient {

    @Override
    public Call<ViandaDTO> get(String qr) {
        return new Call<ViandaDTO>() {
            @Override
            public Response<ViandaDTO> execute() {
                // Simula una respuesta exitosa
                ViandaDTO mockVianda = new ViandaDTO(
                        qr, 
                        LocalDateTime.now(), 
                        EstadoViandaEnum.DEPOSITADA, 
                        1L, 
                        1
                );
                return Response.success(mockVianda);
            }

            @Override
            public void enqueue(Callback<ViandaDTO> callback) {
                ViandaDTO mockVianda = new ViandaDTO(
                        qr, 
                        LocalDateTime.now(), 
                        EstadoViandaEnum.DEPOSITADA, 
                        1L, 
                        1
                );
                callback.onResponse(this, Response.success(mockVianda));
            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {}

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<ViandaDTO> clone() {
                return this;
            }

            @Override
            public Request request() {
                return new Request.Builder().url("http://localhost:8081/viandas/" + qr).build();
            }

            @Override
            public Timeout timeout() {
                return Timeout.NONE;
            }
        };
    }
}
