import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Classe abstrata que representa um pagamento genérico
abstract class Pagamento {
    protected double valor;
    protected LocalDate data;

    public Pagamento(double valor, LocalDate data) {
        this.valor = valor;
        this.data = data;
    }

    // Método abstrato — será implementado nas subclasses
    public abstract void processarPagamento();
}

// Subclasse: pagamento com cartão de crédito
class PagamentoCartaoCredito extends Pagamento {
    private String numeroCartao;

    public PagamentoCartaoCredito(double valor, LocalDate data, String numeroCartao) {
        super(valor, data);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento com Cartão de Crédito no valor de R$" + valor);
    }
}

// Subclasse: pagamento via PIX
class PagamentoPix extends Pagamento {
    private String chavePix;

    public PagamentoPix(double valor, LocalDate data, String chavePix) {
        super(valor, data);
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via PIX no valor de R$" + valor);
    }
}

// Subclasse: pagamento por boleto
class PagamentoBoleto extends Pagamento {
    private String codigoBarras;

    public PagamentoBoleto(double valor, LocalDate data, String codigoBarras) {
        super(valor, data);
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento por Boleto no valor de R$" + valor);
    }
}

// Classe que executa os pagamentos
class CaixaFinanceiro {
    private List<Pagamento> pagamentos = new ArrayList<>();

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public void executarPagamentos() {
        for (Pagamento p : pagamentos) {
            p.processarPagamento();
        }
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        CaixaFinanceiro caixa = new CaixaFinanceiro();

        caixa.adicionarPagamento(new PagamentoCartaoCredito(250.0, LocalDate.now(), "1234-5678-9876-5432"));
        caixa.adicionarPagamento(new PagamentoPix(100.0, LocalDate.now(), "chavepix@email.com"));
        caixa.adicionarPagamento(new PagamentoBoleto(300.0, LocalDate.now(), "34191.79001 01043.510047 91020.150008 5 84970026000"));

        caixa.executarPagamentos();
    }
}
