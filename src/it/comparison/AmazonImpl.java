package it.comparison;

public class AmazonImpl implements Amazon{
    private Fetcher fetcher;
    private Parser parser;
    private String site;

    public AmazonImpl(Fetcher fetcher, Parser parser, String site) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.site = site;
    }

    @Override
    public String findPrice(String isbn) {
        String html = fetcher.fetch(site + "/" + isbn);
        //System.out.println(html);
        return parser.parse(html);
    }

    @Override
    public String getSite() {
        return site;
    }
}
