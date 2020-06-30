package br.com.tlmacedo.cafeperfeito.service;

import br.com.tlmacedo.cafeperfeito.service.alert.Alert_ProgressBar;
import javafx.concurrent.Task;

import java.util.List;

public class ServiceSegundoPlano {


    public boolean executaListaTarefas(Task<?> task, String titulo) throws Exception {
//        ServiceAlertMensagem alertMensagem = new ServiceAlertMensagem(
//                TCONFIG.getTimeOut(),
//                ServiceVariaveisSistema.SPLASH_IMAGENS,
//                TCONFIG.getPersonalizacao().getStyleSheets()
//        );
//        alertMensagem.setCabecalho(titulo);
//        return alertMensagem.alertProgressBar(task, false);

        return new Alert_ProgressBar(task, titulo, false).retorno();
    }

    public boolean executaListaTarefas(List<Task<?>> taskList, String titulo) throws Exception {
        boolean retorno = false;
        for (Task<?> task : taskList)
            retorno = executaListaTarefas(task, titulo);
        return retorno;
    }

    public boolean execListaTarefas(Task<?> task) {
        try {
            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
