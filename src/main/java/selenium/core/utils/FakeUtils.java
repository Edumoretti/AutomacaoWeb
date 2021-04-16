package selenium.core.utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class FakeUtils {
    static Random random = new Random();

    private static final Faker faker = new Faker(new Locale("en-GB"));

    /**
     * Gerar nome de compania aleatoria
     * @return the string
     */
    public static String gerarNomeCompania(){
        return faker.company().name();
    }

    /**
     * Gerar primeiro nome aleatorio
     * @return primeiro nome
     */
    public static String gerarPrimeiroNome(){
        return faker.name().firstName();
    }

    /**
     * Gerar ultimo nome aleatorio
     * @return ultimo nome
     */
    public static String gerarUltimoNome(){
        return faker.name().lastName();
    }

    /**
     * Gerar cep
     * return cep
     */
    public static String gerarCep(){
        return faker.address().zipCode();
    }

    /**
     * Gerar cidade
     * return nome da cidade
     */
    public static String gerarCidade(){
        return faker.address().city();
    }


    /**
     * Gerar nome completo aleatorio
     * @return nome completo
     */
    public static String gerarNomeCompleto(){
        return faker.name().fullName();
    }

    /**
     * Gerar username aleatorio
     * @return username
     */
    public static String gerarNickName(){
        return faker.name().username();
    }

    /**
     * Gerar endereco aleatorio
     * @return endereco
     */
    public static String gerarEndereco() {
        return faker.address().streetAddress();
    }

    /**
     * Gerar email aleatorio
     * @return email
     */
    public static String gerarEmail(){
        return faker.internet().emailAddress();
    }

    /**
     * Gerar phone aleatorio
     * @return phone
     */
    public static String gerarTelefone(){
        return faker.phoneNumber().phoneNumber();
    }


    /**
     * Gerar valor de transacao
     * @return username
     */
    public static float gerarValorTransacaoAleatorio(){
        return Float.parseFloat(random.nextInt(1000)+"."+random.nextInt(100));
    }

    /**
     * Gerar cpf aleatorio
     * @return gerarCpf
     */
    public static String gerarCpf(boolean isValido){
        StringBuilder partial = new StringBuilder();
        String cpf;
        int number;

        for (int i = 0; i < 9; i++) {
            number = (int) (Math.random() * 10);
            partial.append(number);
        }

        if(isValido) {
            cpf = partial.toString() + calculateVerificationDigit(partial.toString());
        } else {
            long elevenDigits = (random.nextInt(1000000000) + (random.nextInt(90) + 10) * 1000000000L);
            cpf = String.valueOf(elevenDigits);
        }

        return cpf;
    }

    /**
     * Gerar cpf formatado aleatorio
     * @return gerarCpf
     */
    public static String gerarCpfFormatado(boolean isValido) {
        String cpf = gerarCpf(isValido);

        return  String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9, 11));
    }

    /**
     * Formatar cpf
     * @return cpf formatado
     */
    public static String formatarCpf(String cpf) {
        return  String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9, 11));
    }

    private static String calculateVerificationDigit(String num) {
        int primDig, segDig, sum = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            sum += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        if (sum % 11 == 0 | sum % 11 == 1) primDig = 0;
        else primDig = 11 - (sum % 11);

        sum = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        }
        sum += primDig * 2;

        if (sum % 11 == 0 | sum % 11 == 1) segDig = 0;
        else segDig = 11 - (sum % 11);

        return Integer.toString(primDig) + segDig;
    }
}
