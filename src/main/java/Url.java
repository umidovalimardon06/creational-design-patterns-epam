public class Url {
    private final String protocol;
    private final String host;
    private Integer port;
    private String pathParam;
    private String queryParam;

    public Url(UrlBuilder urlBuilder) {
        this.protocol = urlBuilder.protocol;
        this.host = urlBuilder.host;
        this.port = urlBuilder.port;
        this.pathParam = urlBuilder.pathParam;
        this.queryParam = urlBuilder.queryParam;
    }

    @Override
    public String toString() {
        StringBuilder url = new StringBuilder();

        if (protocol != null && !protocol.isEmpty()) {
            // Remove any trailing "://"
            String cleanProtocol = protocol.replaceAll("://$", "");
            url.append(cleanProtocol).append("://");
        }

        if (host != null && !host.isEmpty()) {
            url.append(host);
        }

        if (port != null && port > 0) {
            url.append(":").append(port);
        }

        if (pathParam != null && !pathParam.isEmpty()) {
            if (!pathParam.startsWith("/")) {
                url.append("/");
            }
            url.append(pathParam);
        }

        if (queryParam != null && !queryParam.isEmpty()) {
            if (!queryParam.startsWith("?")) {
                url.append("?");
            }
            url.append(queryParam);
        }

        return url.toString();
    }


    public static UrlBuilder builder(String protocol, String host) {
        return new UrlBuilder(protocol, host);
    }

    public static class UrlBuilder {
        private final String protocol;
        private final String host;
        private Integer port;
        private String pathParam;
        private String queryParam;

        public UrlBuilder(String protocol, String host) {
            this.protocol = protocol;
            this.host = host;
        }

        public UrlBuilder port(Integer port) {
            this.port = port;
            return this;
        }

        public UrlBuilder pathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public UrlBuilder queryParam(String queryParam) {
            this.queryParam = queryParam;
            return this;
        }

        public Url build() {
            return new Url(this);
        }

    }
}
