// Karma configuration file, see link for more information
// https://karma-runner.github.io/1.0/config/configuration-file.html

module.exports = function (config) {
  config.set({
    basePath: '',
    frameworks: ['jasmine', '@angular/cli', 'detectBrowsers'],
    plugins: [
      require('karma-chrome-launcher'),
      require('karma-edge-launcher'),
      require('karma-firefox-launcher'),
      require('karma-ie-launcher'),
      require('karma-safari-launcher'),
      require('karma-opera-launcher'),
      require('karma-phantomjs-launcher'),
      require('karma-detect-browsers'),
      require('karma-jasmine'),
      require('karma-jasmine-html-reporter'),
      require('karma-coverage-istanbul-reporter'),
      require('@angular/cli/plugins/karma')
      ],
    client:{
      clearContext: false // leave Jasmine Spec Runner output visible in browser
    },
    coverageIstanbulReporter: {
      reports: [ 'html', 'lcovonly' ],
      fixWebpackSourcePaths: true
    },
    angularCli: {
      environment: 'dev'
    },
    reporters: ['progress', 'kjhtml'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    // configuration
    detectBrowsers: {
      // enable/disable, default is true
      enabled: true,

      // enable/disable phantomjs support, default is true
      usePhantomJS: true,

      // post processing of browsers list
      // here you can edit the list of browsers used by karma
      postDetection: function(availableBrowser) {
        /* Karma configuration with custom launchers
          customLaunchers: {
            IE9: {
              base: 'IE',
              'x-ua-compatible': 'IE=EmulateIE9'
            }
          }
        */

        //Add IE Emulation
        var result = availableBrowser;

        if (availableBrowser.indexOf('IE')>-1) {
          result.push('IE9');
        }

        //Remove PhantomJS if another browser has been detected
        if (availableBrowser.length > 1 && availableBrowser.indexOf('PhantomJS')>-1) {
          var i = result.indexOf('PhantomJS');

          if (i !== -1) {
            result.splice(i, 1);
          }
        }

        return result;
      }
    },
    singleRun: false
  });
};
