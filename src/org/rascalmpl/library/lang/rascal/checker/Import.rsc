module lang::rascal::checker::Import

import lang::rascal::\old-syntax::RascalForImportExtraction;

public set[str] importedModules(Module m) {
  return { "<i>" | /(Import) `import <QualifiedName i>;` := m };
}  

public Module linkImportedModules(Module m, map[str, loc] links) {
  return visit(m) {
    case QualifiedName i:
       if ("<i>" in links)
         insert i[@link=links["<i>"]];
  }
} 