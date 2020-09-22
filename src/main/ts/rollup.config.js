export default {
    input: "dist/index.js",
    onwarn (warning, warn) {
    	if (warning.code === "THIS_IS_UNDEFINED" || warning.code === "CIRCULAR_DEPENDENCY") {
    		return;
    	}
    	warn(warning);
    },
    output: {
    	file: "dist/bundles/jsweet-reproducer.umd.js",
    	format: "umd",
    	name: "reproducer"
    }
};
