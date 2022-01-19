package ru.rest.service;

import org.springframework.stereotype.Service;
import ru.rest.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService{

    // Хранилище клиентов
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID клиента
//    Значение int, которое может быть обновлено атомарно. См. спецификацию VarHandle для описания свойств атомарного доступа. AtomicInteger используется в таких приложениях,
//    как счетчики с атомарным увеличением, и не может использоваться в качестве замены Integer.
//    Однако этот класс расширяет число, чтобы обеспечить единый доступ для инструментов и утилит, работающих с числовыми классами.
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.decrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId,client);

    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)){
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id,client);
            return true;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
    return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }
}