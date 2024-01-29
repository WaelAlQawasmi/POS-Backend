// vue.config.js
module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8089', // Replace with your Spring Boot server URL
                ws: true,
                changeOrigin: true,
            },
        },
    },
};