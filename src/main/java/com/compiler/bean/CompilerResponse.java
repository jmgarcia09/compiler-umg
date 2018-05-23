package com.compiler.bean;

import java.util.List;
import java.util.Map;

public class CompilerResponse {

    private boolean lexiconSuccess;
    private boolean semanticSuccess;
    private boolean syntacticSuccess;
    private List lexiconResult;
    private List semanticResult;
    private List syntacticResult;
    private Map values;

    public CompilerResponse(boolean lexiconSuccess, boolean semanticSuccess, boolean syntacticSuccess, List lexiconResult, List semanticResult, List syntacticResult, Map values) {
        this.lexiconSuccess = lexiconSuccess;
        this.semanticSuccess = semanticSuccess;
        this.syntacticSuccess = syntacticSuccess;
        this.lexiconResult = lexiconResult;
        this.semanticResult = semanticResult;
        this.syntacticResult = syntacticResult;
        this.values = values;
    }

    public CompilerResponse() {
    }

    public boolean isLexiconSuccess() {
        return lexiconSuccess;
    }

    public void setLexiconSuccess(boolean lexiconSuccess) {
        this.lexiconSuccess = lexiconSuccess;
    }

    public boolean isSemanticSuccess() {
        return semanticSuccess;
    }

    public void setSemanticSuccess(boolean semanticSuccess) {
        this.semanticSuccess = semanticSuccess;
    }

    public boolean isSyntacticSuccess() {
        return syntacticSuccess;
    }

    public void setSyntacticSuccess(boolean syntacticSuccess) {
        this.syntacticSuccess = syntacticSuccess;
    }

    public List getLexiconResult() {
        return lexiconResult;
    }

    public void setLexiconResult(List lexiconResult) {
        this.lexiconResult = lexiconResult;
    }

    public List getSemanticResult() {
        return semanticResult;
    }

    public void setSemanticResult(List semanticResult) {
        this.semanticResult = semanticResult;
    }

    public List getSyntacticResult() {
        return syntacticResult;
    }

    public void setSyntacticResult(List syntacticResult) {
        this.syntacticResult = syntacticResult;
    }

    public Map getValues() {
        return values;
    }

    public void setValues(Map values) {
        this.values = values;
    }
}
