
package br.com.templateweb.spring;

import br.com.templateweb.spring.util.ResourceUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class InternacionalizacaoTest {

    private static final Logger log = LoggerFactory.getLogger(InternacionalizacaoTest.class);

    private static ApplicationContext context;

    //@BeforeClass
    public static void init() {
        log.info("Inicializando o contexto do Spring");
        context = new ClassPathXmlApplicationContext("spring/root-applicationContext.xml");
        Assert.assertNotNull(context);
    }

    //@Test
    public void obterMensagemDeDiferenteLocales() {
        Locale US = Locale.US;
        Locale BRASIL = new Locale("pt", "BR");

        final String chave = "label.listar.usuario";
        Assert.assertEquals("List User", context.getMessage(chave, null, US));
        Assert.assertEquals("Listar Usuário", context.getMessage(chave, null, BRASIL));

        resourceBundleTest("i18n/messages", US);
        resourceBundleTest("i18n/messages_pt_BR", BRASIL);
    }

    private void resourceBundleTest(String basename, Locale locale) {
        ResourceBundle bundle = ResourceUtils.getResource(basename, locale);
        Properties properties = ResourceUtils.convertResourceBundleToProperties(bundle);
        
        for (Map.Entry<Object, Object> entrySet : properties.entrySet()) {
            Object key = entrySet.getKey();
            Object value = entrySet.getValue();

            String mensagem = context.getMessage(key.toString(), null, locale);
            log.info(locale.toString() + " - " + mensagem);
            Assert.assertEquals(value, mensagem);
        }
    }
}
