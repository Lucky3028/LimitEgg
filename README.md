# LimitEgg

WorldGuardと連携し、卵またはスポーンエッグの使用に制限をかけることができるMinecraft JE Spigotプラグイン。

## Description

WorldGuardと連携し、自分がOwnerまたはMemberとなっている保護の中にいるときのみ、卵またはスポーンエッグを使用することができるように制限をかけることができるプラグインです。

例えば、自分の保護内において、悪意を持って第三者が卵やスポーンエッグを使用することを防ぎ、サーバーやクライアントに負荷がかかることを回避できます。

## Usage

基本的にはpluginフォルダに入れて、読み込ませるだけで機能します。

config.ymlで指定できることに関しては、ymlを直接参照してください。

コマンドに関しては、[Commands](https://github.com/Lucky3028/LimitEgg#command) の項を参照してください。

### Command

* `/limitegg toggle`
    * このプラグインの制限を受けるかどうかを切り替えることができます。
    * `limitegg.ignoretoggle`のパーミッションを持っているプレイヤーのみが実行可能です。

## Requirement

* Spigot 1.12.2
* WorldGuard 6.2.2

## License

GNU General Public License v3.0
