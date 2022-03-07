package com.nick.javatest;

import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.util.CoreMap;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
public class TestMain {
    public static void main(String[] args) {
        testOpenIE_1();

//         testSegment();
//        testOpenIE_2();
    }

    private static void testOpenIE_1() {
        // Create the Stanford CoreNLP pipeline
//        Properties props = new Properties();
//        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");

//        props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/chinese-distsim/chinese-distsim.tagger");
//        props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/chinese-distsim.tagger");
//        props.setProperty("depparse.model", "edu/stanford/nlp/models/parser/nndep/UD_Chinese.gz");
//        props.setProperty("depparse.language", "chinese");
//        props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/english-left3words-distsim.tagger");

//        StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP");

        StanfordCoreNLP pipeline = null;
        try {
//            pipeline = new StanfordCoreNLP(props);
            pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese");

        }catch (Exception e){
            log.error(e.toString());
        }

        // Annotate an example document.
//        Annotation doc = new Annotation("Obama was born in Hawaii. He is our president.");
        Annotation doc = new Annotation("現代人每天工作忙碌、生活壓力大，加上日常生活都伴隨不了著各種 3C 產品，也讓每晚的睡眠品質受到影響。當民眾長時間面臨各種壓力等不利於良好睡眠的環境，也容易使工作效率下降和健康狀態都持續在負面的循環。而改善睡眠品質方式百百種，不僅可透過醫生的專業協助治療，現在更能居家使用創新頻率科技 SleepBank 睡眠撲滿「為睡眠儲蓄」。");
        pipeline.annotate(doc);

        // Loop over sentences in the document
        for (CoreMap sentence : doc.get(CoreAnnotations.SentencesAnnotation.class)) {
            // Get the OpenIE triples for the sentence
            Collection<RelationTriple> triples =
                    sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            // Print the triples
            for (RelationTriple triple : triples) {
                System.out.println(triple.confidence + "\t" +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationLemmaGloss() + "\t" +
                        triple.objectLemmaGloss());
            }
        }
    }

    @SneakyThrows
    private static void testOpenIE_2() {

        // Create a CoreNLP document
        Document doc = new Document("Obama was born in Hawaii. He is our president.");
//        Document doc = new Document("現代人每天工作忙碌、生活壓力大，加上日常生活都伴隨不了著各種 3C 產品，也讓每晚的睡眠品質受到影響。當民眾長時間面臨各種壓力等不利於良好睡眠的環境，也容易使工作效率下降和健康狀態都持續在負面的循環。而改善睡眠品質方式百百種，不僅可透過醫生的專業協助治療，現在更能居家使用創新頻率科技 SleepBank 睡眠撲滿「為睡眠儲蓄」。");


        // Iterate over the sentences in the document
        for (Sentence sent : doc.sentences()) {
            // Iterate over the triples in the sentence
            for (RelationTriple triple : sent.openieTriples()) {
                // Print the triple
                System.out.println(triple.confidence + "\t" +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationLemmaGloss() + "\t" +
                        triple.objectLemmaGloss());
            }
        }
    }

    private static void testSegment() {

        StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese");

        Annotation doc = new Annotation("他和我在學校裡常打桌球。");
        pipeline.annotate(doc);
        List<CoreMap> sentences = doc.get(CoreAnnotations.SentencesAnnotation.class);
        StringBuffer sb = new StringBuffer();
        for (CoreMap sentence:sentences){
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)){
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                sb.append(word);
                sb.append(" ");
            }
        }

        log.info(sb.toString().trim());
    }
}
